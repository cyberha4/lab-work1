import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Хидир on 08.02.2017.
 */
public class Test_functions {
    int a = this.b;
    int b =5;
    {
        System.out.println(a);
        System.out.println(b);

        Pattern p = Pattern.compile("\\b[а-яА-Я09-]{2,}");
        Matcher m = p.matcher("регулярные выражения это круто регулярные выражения это круто регулярные выражения это круто якороль Я СЕГОДНЯ ЕЛ БАНАНЫ якороль регулярные выражения это круто" );
        if(m.find()){
            System.out.println(m.group());
        }
        while(m.find()){
            System.out.println(m.group());
        }


    }
    public static void main(String[] args) {
        //new Test_functions();

        Byte b = 127;
        System.out.println(++b);

    }
}
