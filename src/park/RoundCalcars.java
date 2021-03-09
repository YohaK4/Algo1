package park;

public class RoundCalcars {
    LinkedListCycle cars;
    int letters = 23;
    char v = 'v';
    char w = 'w';

    public RoundCalcars(int size) {
        cars = new LinkedListCycle();
        for (int i = 0; i < size; i++) {
            char c = (char) ('a' + (int) Math.random()*letters);
            cars.add(c, size);
        }
    }

    public int calcars(){
        cars.getHead().setData(v);
        LinkedListCycle.Node t = cars.getHead().getNext();
        boolean flag = true;
        int count = 1;

        while(flag){
            if(t.getData() == 'v'){
                t.setData(w);
                int i = 0;

                while(i!=count) {
                    t=t.getPrev();
                    i++;
                }
                if(t.getData() == 'w'){
                    flag = false;
                }
                else{
                    t = cars.getHead().getNext();
                    count=1;
                }
            }
            else{
                t=t.next;
                count++;
            }
        }
        System.out.println(count);
        return count;
    }
}
