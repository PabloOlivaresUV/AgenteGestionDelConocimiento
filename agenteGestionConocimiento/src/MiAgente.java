/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class MiAgente extends Agent {
    
    protected void setup(){
        System.out.println("JADE EJEMPLO Agente Gestión del Conocimiento");
        System.out.println("My name local is "+getLocalName());
        System.out.println("“My GUID is "+getAID().getName());
        
        System.out.println("Agregando behaviour... Es un comportamiento de ejecución única");
        addBehaviour(new GenerarAgentes(this));
        
    }

    
    class GenerarAgentes extends OneShotBehaviour{

        GenerarAgentes(Agent a){
            super(a);
        }
        
        public void action(){
            
            String UserID;
            String sellerID;
            
            try{
                jade.wrapper.AgentController ref;

                ref = myAgent.getContainerController().acceptNewAgent("AgenteGestionConocimiento",new AgenteGC());
                ref.start(); 
                
                //sellerID = ref.;
                //System.out.println("My name local is "+ref.getName());
                
                for(int agentCounter=1; agentCounter<8; agentCounter++){
                    
                    UserID = "Usuario_"+agentCounter+"_";
                    
                    ref = myAgent.getContainerController().acceptNewAgent(UserID,new Usuario());
                    ref.start();                    

                    System.out.println("My name local is "+ref.getName());
                    doWait(7000);
                }
                
            }catch(Exception e){
                System.out.println("Error en añadir agentes al container!");
            }

            blockingReceive();            
            

        } 

        
        
    }

}

