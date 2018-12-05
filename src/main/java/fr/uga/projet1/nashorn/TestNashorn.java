package fr.uga.projet1.nashorn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import fr.uga.projet1.lambda.Etudiant;
import jdk.nashorn.api.scripting.ScriptObjectMirror;

public class TestNashorn {

	public static void main(String[] args) {
		try {
			ScriptEngine engine = 
						new ScriptEngineManager().getEngineByName("nashorn");
			
			//Evaluation d'une instruction js
			engine.eval("print('Coucou from JS');");
			
			//Evaluation d'un fichier
			BufferedReader reader = new BufferedReader(new FileReader("mesScripts.js"));
			engine.eval(reader);
			reader.close();
			
			Invocable invocable = (Invocable)engine;
			
			System.out.println("Appel simple avec param String");
			Object resFn1 = invocable.invokeFunction("fn1", "TOTO");
			System.out.println(resFn1);
			System.out.println(resFn1.getClass());
			
			System.out.println("Appel avec un objet");
			//invocable.invokeFunction("fn2", new Date());
			invocable.invokeFunction("fn2", new Etudiant("toto","prenomToto",16));
			
			invocable.invokeFunction("fn3", "toto");
			
			invocable.invokeFunction("fn4", "test affichage type d'un objet");
			
			
			invocable.invokeFunction("fn5", "test envoi json depuis js");
			
			invocable.invokeFunction("fn6", "appel mÃ©thode dans un objet JS");
			
			
			//try with resource : ferme les flux ouverts dans le bloc try
//			try(BufferedReader reader2 = new BufferedReader(new FileReader("mesScripts.js"))){
//				engine.eval(reader2);
//			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void methodJava1(String nom) {
		System.out.println("methodJava 1 : helloooo");
	}
	
	public static void methodJava2(Object obj) {
		System.out.println("methodJava 2 :" + obj.getClass());
	}
	
	public static void methodJava3(ScriptObjectMirror mirror) {
		System.out.println(mirror.getClassName());
		System.out.println(mirror.get("nom") + " " + mirror.get("tel"));
	}
	
	public static void methodJava4(ScriptObjectMirror mirror) {
		System.out.println("retour JS = " + mirror.callMember("getNomComplet"));
	}
	
}