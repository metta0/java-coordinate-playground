package Model;

class CoordinateVariable {
    int value;

    CoordinateVariable(int value){
        if(value>24 || value<0) throw new IllegalArgumentException();

        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof CoordinateVariable)) return false;

        CoordinateVariable variable = (CoordinateVariable) obj;
        return this.getValue() == variable.getValue();
    }

    int getValue(){
        return this.value;
    }
}
