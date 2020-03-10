public class WordSet {
    // WordSet properties
    protected Node head;

    // node of the WordSet
    private class Node {

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

    // constructors
    public WordSet(){
        this.head = null;
    }

    // constructor #2 which merges two WordSets
    public WordSet(WordSet w1,WordSet w2){
        this.head = w1.head;
        Node e1 = w1.head;
        while (e1.getNext()!=null){
            e1 = e1.getNext();
        }
        e1.setNext(w2.head);
    }

    // toSting WordSet
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

    // deletes word from the WordSet
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

    // deletes palindrome from the WordSet
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

    // check to the palindrome
    private boolean checkPolindrom(String str){
        for (int i = 0;i<(int) str.length()/2;i++){
            if (str.charAt(i)!=str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    // compares two Strings lexicographically
    public int compareTo(String w1,String w2){
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

    // *--------*
    // insert new Node in the WordSet
    public void insert(String word) {
        if (!contains(word)) {
            if (this.head == null) {
                this.head = new Node(word, null);
            } else {
                Node nextNode = this.head;
                while (nextNode.getNext() != null && compareTo(nextNode.getData(), word) > 0) {
                    nextNode = nextNode.getNext();
                }
                Node newNode = new Node(word, nextNode.getNext());
                nextNode.setNext(newNode);
            }
        }
    }


    // true - includes; false - not
    public boolean contains(String word) {
        if (this.head == null) {
            return false;
        } else {
            if (word.equals(this.head.data)) {
                return true;
            } else {
                Node nextNode = this.head;
                while (nextNode != null) {
                    if (word.equals(nextNode.getData())) {
                        return true;
                    } else {
                        nextNode = nextNode.getNext();
                    }
                }
                return false;
            }
        }
    }

    // constructor #1
    public WordSet(String[] arr) {
        this.head = null;
        for (int i = 0; i < arr.length; i++) {

        }
    }

    public String[] modifyArray(String[] str) {
        String[] result = new String[str.length];
        int uniqAmount = 0;
        for (int i = 0; i < str.length; i++) {
            boolean flag = true;
            String element = str[i];
            for (int j = 0; j < result.length; j++) {
                if (element.equals(result[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result[uniqAmount] = element;
                uniqAmount++;
            }
        }
        return result;
    }
}
