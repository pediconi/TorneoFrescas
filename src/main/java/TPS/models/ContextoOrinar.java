package TPS.models;

import TPS.interfaces.Orinar;

public class ContextoOrinar {

        private Orinar orinar;                  // creo variable de la interfaz orinar

        public ContextoOrinar(Orinar orinar){      // aca puedo recibir cualquier implementacion de la interfaz orinar
            this.orinar = orinar;
        }

        public int ejecutar(int num){               // ejecuto el metodo de la interfaz orinar
                                                    // para la implemetacion realizada
            return orinar.comenzarOrinada(num);
        }

}
