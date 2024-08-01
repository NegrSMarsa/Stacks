interface Stack{
    void push(int item);
    int pop();
}
class FixedStack implements Stack{
    private int stck[];
    private int tos;
    FixedStack(int size){
        stck = new int[size];
        tos = -1;
    }

    public void push(int item){
        if (tos==stck.length - 1) System.out.println("Стек заполнен.");
        else stck[++tos] = item;
    }
    public int pop(){
        if(tos<0){
            System.out.println("Стек не загружен.");
            return 0;
        }
        else return stck[tos--];
    }
}

class DynStack implements Stack {
    private int stck[];
    private int tos;

    DynStack(int size) {
        stck = new int[size];
        tos = -1;
    }

    public void push(int item) {
        if (tos == stck.length - 1) {
            int temp[] = new int[stck.length * 2];
            for (int i = 0; i < stck.length; i++) temp[i] = stck[i];
            stck = temp;
            stck[++tos] = item;
        } else stck[++tos] = item;

    }

    public int pop(){
        if(tos<0){
            System.out.println("Стек не загружен.");
            return 0;
        }
        else return stck[tos--];
    }
}

public class IntStack {
    public static void main(String[] args){
        Stack mystack;
        //создать переменную ссылки на интерфейс
        DynStack ds = new DynStack(5);
        FixedStack fs = new FixedStack(8);
        mystack = ds; // загрузить динамический стек
        //разместить числа в стеке
        for(int i=0; i<12; i++) mystack.push(i);
        mystack = fs; // загрузить фиксированный стек
        for(int i=0; i<8; i++) mystack.push(i);
        mystack = ds;
        System.out.println("Знaчeния в динамическом стеке:");
        for(int i=0; i<12; i++)
            System.out.println(mystack.pop() );
        mystack = fs;
        System.out.println("Знaчeния в фиксированном стеке:");
        for(int i = 0; i < 8; i++){
            System.out.println(mystack.pop());
        }
    }
}