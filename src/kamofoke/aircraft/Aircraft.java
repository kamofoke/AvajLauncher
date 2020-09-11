package kamofoke.aircraft;

public abstract class Aircraft {

    //importing coordinates
    
        protected long id;
        protected String name;
        protected Coordinates coordinates;
        private static long idCounter = 1;
    
    
    //contrucrtors
    
        protected Aircraft(String name, Coordinates coordinates){
            this.name = name;
            this.coordinates = coordinates;
            this.id = nextId();
        }
        
        private long nextId(){
            return (idCounter++);
        }
    }