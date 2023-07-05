export class Categories{
    public id:string | unknown;
    constructor(
        public name:string,
        public type:boolean){
            
        }
    getId(){
        return this.id;
    }  
    getName(){
        return this.name;
    }  
    getType(){
        return this.type;
    }    
}