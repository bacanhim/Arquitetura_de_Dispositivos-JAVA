/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uma.ctesp.arq.Ficha3;

/**
 *
 * @author Turma A
 */
public class CharacterUtilities {
    public static char lowerLetterSuccessorOf(char a){
        a++;    
        if(a =='{'){
           a='a';
        }
     return a;   
    }
    public static char lowerLetterPredecessorOf(char a){
        a--; 
        if(a =='`'){
           a='z';
        }     
     return a;   
    }
    public static char lowerLetterSuccessorStepsOf(char a,int val){
        for (int i = 0; i<val; i++){
            a++;
        }
        if(a =='{'){
           a='a';
        }
     return a;   
    }
    public static char lowerLetterPredecessorStepsOf(char a,int val){
        for (int i = 0; i<val; i++){
            a--;
        }
        if(a =='`'){
           a='z';
        }
     return a;   
    }
    public static int occurrencesOfCharacterIn(char[] array,char letter){
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]==letter){
                num++;
            }
        }
        return num;
    }
}
