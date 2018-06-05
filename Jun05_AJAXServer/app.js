
/**
 * Module dependencies.
 */

var express = require('express')
  , routes = require('./routes')
  , user = require('./routes/user')
  , http = require('http')
  , path = require('path');

var app = express();

// all environments
app.set('port', process.env.PORT || 3000);
app.set('views', __dirname + '/views');
app.set('view engine', 'jade');
app.use(express.favicon());
app.use(express.logger('dev'));
app.use(express.bodyParser());
app.use(express.methodOverride());
app.use(app.router);
app.use(express.static(path.join(__dirname, 'public')));

// development only
if ('development' == app.get('env')) {
  app.use(express.errorHandler());
}

// http://localhost:3000/getSnack
app.get('/getSnack', function(req, res){
	var db = require('mongojs')('localhost/jun05', ['snack']);
	
	// mongoDB 명령어
	db.snack.find(function(err, result){
		// JS객체 -> String
		res.send(JSON.stringify(result));
		
	});
	
	
});

// http://localhost:3000/searchSnack?s_price=1000
// &callback=xcz
app.get('/searchSnack', function(req, res){
	var p = req.query.s_price * 1;
	var cb = req.query.callback;
	
	var db = require('mongojs')('localhost/jun05', ['snack']);
	db.snack.find({s_price:{'$lte':p}}, function(err, result){
		// JS객체 -> String
		res.send(cb + '(' + JSON.stringify(result) + ')');
	});
});

app.get('/searchSnack2', function(req, res){
	var n = req.query.s_name;
	var db = require('mongojs')('localhost/jun05', ['snack']);
	db.snack.find({_id:{'$regex':n}}, function(err, result){
		res.send(JSON.stringify(result));
	});
});

app.get('/insertSnack', function(req, res){
	var n = req.query.s_name;
	var p = req.query.s_price;
	var db = require('mongojs')('localhost/jun05', ['snack']);
	db.snack.insert({_id:n, s_price:p}, function(err, result){
		res.send(JSON.stringify(result));
	});
});

http.createServer(app).listen(app.get('port'), function(){
  console.log('Express server listening on port ' + app.get('port'));
});
