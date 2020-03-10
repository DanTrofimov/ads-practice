public class WordSet {

    protected Node head;
    private class Node{

        private String data;
        private Node next;

        public Node(){
            this.data = null;
            this.next = null;
        }

        public Node(String data, Node next){
            this.data = data;
            this.next = next;
        }

        public Node(String data){
            this.data = data;
            this.next = null;
        }

        public String getData(){
            return data;
        }

        public Node getNext(){
            return next;
        }

        public void setNext(Node next){
            this.next = next;
        }

        public void setData(String data){
            this.data = data;
        }
    }

    public WordSet(){
        this.head = null;
    }

    public WordSet(WordSet w1,WordSet w2){
        this.head = w1.head;
        Node e1 = w1.head;
        while (e1.getNext()!=null){
            e1 = e1.getNext();
        }
        e1.setNext(w2.head);
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        Node item = this.head;
        str.append(item.getData());
        while (item.getNext()!=null){
            str.append("->");
            item = item.getNext();
            str.append(item.getData());
        }
        return str.toString();
    }

    public void delete(String word){
        if (word.equals(this.head.getData())){
            head = this.head.getNext();
        }
        Node del = this.head.getNext();
        Node l = this.head;
        while (del.getNext()!=null){
            if (del.getData().equals(word)){
                break;
            }
            l = del;
            del = del.getNext();
        }
        if (del.getData().equals(word)){
            l.setNext(del.getNext());
        }
    }

    public void removePalindrom(){
        while (this.checkPolindrom(this.head.getData())){
            this.head = head.getNext();
        }
        Node del = this.head.getNext();
        Node l = this.head;
        while (del.getNext()!=null){
            if (this.checkPolindrom(del.getData())){
                l.setNext(del.getNext());
                del = del.getNext();
            } else {
                l = del;
                del = del.getNext();
            }
        }
        if (this.checkPolindrom(del.getData())) {
            l.setNext(null);
        }
    }


    private boolean checkPolindrom(String str){
        for (int i = 0;i<(int) str.length()/2;i++){
            if (str.charAt(i)!=str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    private int compareTo(String w1,String w2){
        char ch1,ch2;
        for (int i = 0;i<Math.min(w1.length(), w2.length());i++){
            ch1 = w1.charAt(i);
            ch2 = w2.charAt(i);
            if ((ch1>='A')&&(ch1<='Z')){
                if ((ch2>='A')&&(ch2<='Z')){
                    if (!(ch1==ch2)){
                        return -(ch1-ch2);
                    }
                } else if ((ch2>='a')&&(ch2<='z')){
                    return -(ch1-ch2);
                }
            } else if ((ch1>='a')&&(ch1<='z')){
                if ((ch2>='A')&&(ch2<='Z')){
                    return (ch1-ch2);
                } else if ((ch2>='a')&&(ch2<='z')){
                    if (!(ch1==ch2)){
                        return -(ch1-ch2);
                    }
                }
            }
        }
        int ans;
        if (w1.length()==w2.length()){
            ans = 0;
        } else {
            ans = w1.length() - w2.length();
        }
        return ans;
    }
}
