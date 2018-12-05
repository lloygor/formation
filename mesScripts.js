print('Hello from JS FILE');

var fn1 = function(nom){
	return 'Hi from FN1 ' + nom;
}

var fn2 = function(obj){
	print('js class' + Object.prototype.toString.call(obj));
}

//Appel d'une mÃ©thode se trouvant dans le code Java
var fn3 = function(nom){
	var myJavaClass = Java.type('fr.uga.projet1.js.TestNashorn');
	var res = myJavaClass.methodJava1(nom);
	print(res);
}

var fn4 = function(titre){
	print(titre);
	var myJavaClass = Java.type('fr.uga.projet1.js.TestNashorn');
	myJavaClass.methodJava2(123);
//	myJavaClass.methodJava1("hello");
//	myJavaClass.methodJava1(true);
//	myJavaClass.methodJava1(new Number(23));
//	myJavaClass.methodJava1({foo:'toto'});	
}

var fn5 = function(titre){
	print(titre);
	var myJavaClass = Java.type('fr.uga.projet1.js.TestNashorn');
	myJavaClass.methodJava3({nom:'Mohamed',tel:'0666666666'});
}

function Etudiant(nom, prenom, moyenne){
	this.nom = nom;
	this.prenom = prenom;
	this.moyenne = moyenne;
	
	this.getNomComplet = function(){
		return this.nom + " " + this.prenom;
	}
}

var fn6 = function(titre){
	print(titre);
	var myJavaClass = Java.type('fr.uga.projet1.js.TestNashorn');
	var co1 = new Etudiant('toto','prenomToto',16);
	myJavaClass.methodJava4(co1);
}

var fun7 = function(titre){
	print(titre);
	var myList = new java.util.ArrayList();
	myList.add('aaa');
	myList.add('bbb');
	
	var jEtudiant = Java.type('fr.uga.projet1.lambda.Etudiant');
	var p1 = new jEtudiant;
}

var fn8 = function(){
	var Runnable = Java.type('java.lang.Runnable');
	var myRunnable = Java.extend(Runnable, {
		run : function(){
			print('hi from myThread in JavaScript');
		}
	});
	var Thread = Java.type('java.lang.Thread');
	var th1 = new Thread(new myRunnable()).start();
	
	//Ex2
	new Thread(function(){
		print('hi from myThread in JavaScript');
	}).start();
}


