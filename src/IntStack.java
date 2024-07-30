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
        FixedStack mystack1 = new FixedStack(5);
        FixedStack mystack2 = new FixedStack(8);

        for (int i = 0; i < 5; i++) mystack1.push(i);
        for (int i = 0; i < 8; i++) mystack2.push(i);

        System.out.println("Стек в mystack1: ");
        for (int i = 0; i < 5; i++) System.out.println(mystack1.pop());
        System.out.println();

        System.out.println("Стек в mystack2: ");
        for (int i = 0; i < 8; i++) System.out.println(mystack2.pop());
        System.out.println();

        DynStack myDynStack1 = new DynStack(5);
        DynStack myDynStack2 = new DynStack(8);

        for(int i=0; i<12; i++) myDynStack1 .push(i);
        for(int i=0; i<20; i++) myDynStack2.push(i);

        System.out.println("Cтeк в myDynStack1:");
        for(int i=0; i<12; i++)
            System.out.println(myDynStack1.pop());
        System.out.println();

        System.out.println("Cтeк в myDynStack2:");
        for(int i=0; i<20; i++)
            System.out.println(myDynStack2.pop());

    }
}