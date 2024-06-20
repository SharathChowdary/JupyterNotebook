import java.lang.annotation.Annotation;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhone{
    String os() default "myOS";
    int version() default 3;
}

@SmartPhone(os="Android",version = 69)
class NokiaASeries{
    String model;
    int size;
    NokiaASeries(String model,int size){
        this.model=model;
        this.size=size;
    }
}
class AnnotationsExample{
    public static void main(String[] args){
        NokiaASeries obj=new NokiaASeries("Fire",5);
        Class c=obj.getClass();
        Annotation an=c.getAnnotation(SmartPhone.class);
        SmartPhone s=(SmartPhone) an;
        System.out.println(s.os());
        System.out.println(s.version());
    }
}