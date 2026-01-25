package Implementation_side;
import java.lang.ArithmeticException;

enum NumericType {
    INTEGER,
    LONG,
    FLOAT,
    DOUBLE
}


interface operations{
    Number add (Number a , Number b);
    Number sub (Number a , Number b);
    Number mult(Number a, Number b);
    Number div (Number a , Number b);
    Number calculate(Number n1, Number n2, char op);
}
class NumbersHandling{
    static NumericType detect(Number n) {
    if (n instanceof Double) return NumericType.DOUBLE;
    if (n instanceof Float) return NumericType.FLOAT;
    if (n instanceof Long) return NumericType.LONG;
    return NumericType.INTEGER;
    }
    static NumericType promote(Number a, Number b){
        NumericType type = (detect(a).ordinal() > detect(b).ordinal()) 
        ? detect(a) : detect(b);
        return type;
    }


}
public class Calculator implements operations{
    private Number result;
    public Calculator(){
        this.result = null;
    }
    @Override
    public Number add(Number a , Number b){
        NumericType type = NumbersHandling.promote(a, b);
        this.result = switch(type){
            case INTEGER -> a.intValue() + b.intValue();
            case LONG -> a.longValue() + b.longValue();
            case FLOAT -> a.floatValue() + b.floatValue();
            case DOUBLE -> a.doubleValue() + b.doubleValue();
        };
        return this.result;
    }
    @Override
    public Number sub(Number a , Number b){
        NumericType type = NumbersHandling.promote(a, b);
        this.result = switch(type){
            case INTEGER -> a.intValue() - b.intValue();
            case LONG -> a.longValue() - b.longValue();
            case FLOAT -> a.floatValue() - b.floatValue();
            case DOUBLE -> a.doubleValue() - b.doubleValue();
        };
        return this.result;
    }
    @Override
    public Number mult(Number a , Number b){
        NumericType type = NumbersHandling.promote(a, b);
        this.result = switch(type){
            case INTEGER -> a.intValue() * b.intValue();
            case LONG -> a.longValue() * b.longValue();
            case FLOAT -> a.floatValue() * b.floatValue();
            case DOUBLE -> a.doubleValue() * b.doubleValue();
        };  
        return this.result;
    }
    @Override
    public Number div(Number a , Number b){
        if (b.doubleValue() == 0){
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        this.result =  (double) a.doubleValue() / b.doubleValue();
        return this.result;
    }
    @Override
    public  Number calculate(Number n1, Number n2, char op){
        return switch(op){
            case '+' -> add(n1,n2);
            case '-' -> sub(n1,n2);
            case '*' -> mult(n1,n2);
            case '/' -> div(n1,n2);
            default -> null;
        };
}
}