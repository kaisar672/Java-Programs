import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
class CreateOwnLinkedList{
    static int size;
    Node createList(){
        System.out.print("Enter the Number of nodes You want To create : ");
        Scanner scan=new Scanner(System.in);
        size=scan.nextInt();
        Node head=null;
        Node prevNode=null;
        for (int i=0;i<size;i++){
            System.out.print("Enter The data : ");
            Node currNode=new Node(scan.nextInt());
            //prevNode=currNode;
            if(i==0) {
                head = currNode;
                prevNode = head;
            }
            else {
                prevNode.next = currNode;
                currNode.next = null;
                prevNode = currNode;
            }
        }
        System.out.println(size+" nodes have been created.");
        System.out.println("********************************");
        return head;
    }
    Node insertNodeAnywhere(Node head){
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter The Location from 1 to "+(size+1)+" including("+(size+1)+") : ");
        int location=scan.nextInt();
        System.out.print("Enter The Data :  ");
        Node currNode=new Node(scan.nextInt());
        int i=1;
        if(location==1){
            currNode.next=head;
            head=currNode;
        }
        else if(location==size+1){
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=currNode;
        }
        else if(location>1 && location<=size){
            Node temp=head;
            while(i<location-1) {
                temp = temp.next;
                i++;
            }
            currNode.next=temp.next;
            temp.next=currNode;
        }
        else
            System.out.println("You have not Entered valid Location");
        System.out.println("Node is Inserted At Location : "+location);
        System.out.println("******************************");
        size++;
        return head;
    }
    void display(Node temp){
        System.out.println("The Output is :");
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
        System.out.println("***********************");
    }
    void displayTotalNodes(){
        System.out.println("Total Nodes Are : "+size);
    }
    public static void main(String[] args){
        CreateOwnLinkedList obj=new CreateOwnLinkedList();
        Scanner scan=new Scanner(System.in);
        int flag=0;
        Node head=null;
        while(true){
            if(flag==1)
                break;
            obj.displayTotalNodes();
            System.out.println("Your Available Choices Are :");
            System.out.println("    1.Create LinkedList.\n    2.Display List.\n    3.Insert Node AnyWhere.\n    4.Exit.");
            System.out.println("***************************");
            System.out.print("Enter the choice : ");
            int choice=scan.nextInt();
            switch(choice){
                case 1: if(size==0)
                            head = obj.createList();
                        else if (size>0){
                            System.out.println("You have Already Created The List.");
                            System.out.println("Do Other Operations : ");
                            System.out.println("**********************************");

                        }
                        break;
                case 2: if(size>0)
                            obj.display(head);
                        else if (size==0) {
                            System.out.println("You have not created the list yet");
                            System.out.println("To Display. Create The List First.");
                            System.out.println("**********************************");
                        }
                        break;
                case 3: if(size>0)
                            head=obj.insertNodeAnywhere(head);
                        else {
                            System.out.println("You have not created the list yet");
                            System.out.println("To Insert Node Any Where. Create The List First.");
                            System.out.println("**********************************");
                        }
                        break;
                case 4: flag=1;
                        break;
                default: System.out.println("You have Entered wrong Choice");
            }
        }
    }
}