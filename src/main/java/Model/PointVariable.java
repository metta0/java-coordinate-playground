package Model;

class PointVariable {
    int value;

    PointVariable(int value){
        if(value>24 || value<0) throw new IllegalArgumentException("입력 숫자의 범위는 0이상 24이하 입니다. 다시 입력해 주세요 : ");

        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof PointVariable)) return false;

        PointVariable variable = (PointVariable) obj;
        return this.getValue() == variable.getValue();
    }

    int getValue(){
        return this.value;
    }
}
