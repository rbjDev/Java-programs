package Generics;

import java.lang.reflect.GenericArrayType;


//To make the class generic as well
class GenericInterface2<T> implements GenericInterface<T>{

    @Override
    public T get() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void set(T item) {
        // TODO Auto-generated method stub
        
    }
  
}

//To make class of specific type
class GenericIntfImpl3 implements GenericInterface<Integer>{

    @Override
    public void set(Integer item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public Integer get() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }    
}

//If generic type is not specified for class or interface
class GenericIntfImpl4 implements GenericInterface{

    @Override
    public Object get() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void set(Object item) {
        // TODO Auto-generated method stub
        
    }
    
}