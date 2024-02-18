
import java.util.Scanner;
public class NumberConversion {
    int ind=-1,flag=1;
    int takeDecimalNumber(){
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter Decimal Number : ");
        int num =scan.nextInt();
        return num;
    }
    String takeBinaryNumber(){
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter Binary Number : ");
        String str=scan.nextLine();
        return str;
    }
    int takeOctalNumber(){
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter Octal Number : ");
        int num =scan.nextInt();
        return num;
    }
    String takeHexadecimalNumber(){
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter Hexadecimal Number : ");
        String str=scan.nextLine();
        return str;
    }
    void display(int arr[]){
        for(int i=ind;i>=0;i--){
            System.out.print(arr[i]);
        }
        System.out.println();
    }
    void display(char arr[]){ // This function is used to print Hexadecimal Numbers
        for(int i=ind;i>=0;i--){
            System.out.print(arr[i]);
        }
        System.out.println();
    }
    int[] decimalToBinary(int num){
        int arr[]=new int[50];
        ind=-1;
        while(num>1){
            arr[++ind]=num%2;
            num=num/2;
        }
        arr[++ind]=1;
        return arr;
    }
    int[] decimalToOctal(int num){
        int arr[]=new int[50];
        ind=-1;
        while(num>7){
            arr[++ind]=num%8;
            num=num/8;
        }
        arr[++ind]=num;
        return arr;
    }
    char[] assignAlphabet(int num,char arr[]){
        //System.out.println("Num="+num);
        if(num==10)
            arr[++ind]='A';
        else if(num==11)
            arr[++ind]='B';
        else if(num==12)
            arr[++ind]='C';
        else if(num==13)
            arr[++ind]='D';
        else if(num==14)
            arr[++ind]='E';
        else if(num==15)
            arr[++ind]='F';
        return arr;
    }
    char[] decimalToHexadecimal(int num){
        char arr[]=new char[50];
        ind=-1;
        int rem=0;
        while(num>15){
            rem=num%16;
            if(rem<10) {
                arr[++ind] = (char)(rem+'0');
            }
            else {
                arr = this.assignAlphabet(rem, arr);
            }
            num=num/16;
        }
        if(num>9) {
            arr = this.assignAlphabet(num, arr);
        }
        else
            arr[++ind]=(char)(num+'0');
        return arr;
    }
    int binaryToDecimal(String str){
        int power=1,value=0,rem=0,prod=0,i=(str.length()-1);
        while(i>=0){
            rem=Character.getNumericValue(str.charAt(i));
            prod=power*rem;
            value=value+prod;
            power=power*2;
            i--;
        }
        return value;
    }
    int[] binaryToOctal(String str){
        int value=this.binaryToDecimal(str);
        // System.out.println("The conversion Binary to decimal is : "+value);
        int arr2[]=this.decimalToOctal(value);
        return arr2;
    }
    char[] binaryToHexadecimal(String str){
        int value=this.binaryToDecimal(str);
        //  System.out.println("The conversion Binary to decimal is : "+value);
        char arr2[]=this.decimalToHexadecimal(value);
        return arr2;
    }
    int octalTodecimal(int num){
        int power=1,rem=0,value=0,prod=0;
        while(num>7){
            rem=num%10;
            prod=rem*power;
            value=value+prod;
            power=power*8;
            num=num/10;
        }
        prod=num*power;
        value=value+prod;
        return value;

    }
    int[] octalToBinary(int num){
        int arr[]=new int[50];
        int rem=0,temp;
        ind=-1;
        while(num>7){
            rem=num%10;
            temp=rem;
            while(temp>1){
                arr[++ind]=temp%2;
                temp=temp/2;
            }
            arr[++ind]=1;
            if(rem<=3){
                arr[++ind]=0;
                if(rem==1)
                    arr[++ind]=0;
            }
            num=num/10;
        }
        rem=num;
        while(rem>1){
            arr[++ind]=rem%2;
            rem=rem/2;
        }
        arr[++ind]=1;
        if(num<=3){
            arr[++ind]=0;
            if(num==1)
                arr[++ind]=0;
        }
        return arr;
    }
    char[] octalToHexadecimal(int num) {
        int value = this.octalTodecimal(num);
        char arr2[] = this.decimalToHexadecimal(value);
        return arr2;
    }
    int extractValue(char ch){
        if(ch=='A' || ch=='a')
            return 10;
        else if(ch=='B' || ch=='b')
            return 11;
        else if(ch=='C' || ch=='c')
            return 12;
        else if(ch=='D' || ch=='d')
            return 13;
        else if(ch=='E' || ch=='e')
            return 14;
        else if(ch=='F' || ch=='f')
            return 15;
        return 0;

    }
    int hexadecimalToDecimal(String str){
        int num=0,i=(str.length()-1),power=1,prod=0,value=0;;
//        long power=1,prod=0,value=0;
        char ch;
        while(i>=0){
            ch=str.charAt(i);
            if( (ch>=65 && ch<=90) || (ch>=97 && ch<=122))
                num=this.extractValue(ch);
            else
                num=Character.getNumericValue(ch);
            prod=power*num;
            value=value+prod;
            power=power*16;
            i--;
        }
        return value;
    }
    int[] hexadecimalToBinary(String str){
        int value=this.hexadecimalToDecimal(str);
        int arr[]=this.decimalToBinary(value);
        return arr;
    }
    int[] hexadecimalToOctal(String str){
        int value=this.hexadecimalToDecimal(str);
        int arr[]=this.decimalToOctal(value);
        return arr;
    }
    public static void main(String[] args){
        NumberConversion ob=new NumberConversion();
        Scanner scan=new Scanner(System.in);
        System.out.println("1: Decimal To Binary\n2:Decimal To Octal\n3:Decimal To Hexadecimal\n" + "4:Binary To Decimal\n5:Binary To Octal\n6:Binary To Hexadecimal\n" +"7:Octal To Decimal\n8:Octal To Binary\n9:Octal To Hexadecimal\n"+  "10:HexaDecimal To Decimal\n11:Hexadecimal To Binary\n12:HexaDecimal To Octal\n13:Exit.");
        int num=0,value=0;
        int arr[];
        char arr2[];
        int flag=0;
        String str;
        while(true) {
            //ind=-1;
            if(flag==1)
                break;
            System.out.print("Enter The Choice : ");
            int choice=scan.nextInt();
            switch (choice) {
                case 1:
                    num = ob.takeDecimalNumber();
                    arr = ob.decimalToBinary(num);
                    System.out.print("The Conversion of Decimal To Binary is : ");
                    ob.display(arr);
                    break;
                case 2:
                    num = ob.takeDecimalNumber();
                    arr = ob.decimalToOctal(num);
                    System.out.print("The Conversion of Decimal To Octal is : ");
                    ob.display(arr);
                    break;
                case 3:
                    num = ob.takeDecimalNumber();
                    arr2 = ob.decimalToHexadecimal(num);
                    System.out.print("The Conversion of Decimal To Hexadecimal is : ");
                    ob.display(arr2);
                    break;
                case 4:
                    str = ob.takeBinaryNumber();
                    value = ob.binaryToDecimal(str);
                    System.out.println("The conversion Binary to decimal is : " + value);
                    break;
                case 5:
                    str = ob.takeBinaryNumber();
                    arr = ob.binaryToOctal(str);
                    System.out.print("The conversion of binary into octal is : ");
                    ob.display(arr);
                    break;
                case 6:
                    str = ob.takeBinaryNumber();
                    arr2 = ob.binaryToHexadecimal(str);
                    System.out.print("The conversion of binary into hexadecimal is :");
                    ob.display(arr2);
                    break;
                case 7:
                    num = ob.takeOctalNumber();
                    value = ob.octalTodecimal(num);
                    System.out.println("The conversion of " + num + " into decimal is : " +    value);
                    break;
                case 8:
                    num = ob.takeOctalNumber();
                    arr = ob.octalToBinary(num);
                    System.out.print("The conversion of octal " + num + " into binary i=");
                    ob.display(arr);
                    break;
                case 9: num=ob.takeOctalNumber();
                    arr2=ob.octalToHexadecimal(num);
                    System.out.print("The conversion of octal To Hexadecimal is : ");
                    ob.display(arr2);
                    break;
                case 10: str=ob.takeHexadecimalNumber();
                    value=ob.hexadecimalToDecimal(str);
                    System.out.println("The conversion of Hexadecimal To Decimal is : "+value);
                    break;
                case 11: str=ob.takeHexadecimalNumber();
                    arr=ob.hexadecimalToBinary(str);
                    System.out.print("The Conversion of Hexadecimal To Binary is :  ");
                    ob.display(arr);
                    break;
                case 12: str=ob.takeHexadecimalNumber();
                    arr=ob.hexadecimalToOctal(str);
                    System.out.print("The Conversion of Hexadecimal To Octal is : ");
                    ob.display(arr);
                    break;
                case 13: flag = 1;
                    break;
                default:
                    System.out.println("You have Entered Incorret Choice.");
                    break;
            }
        }
    }
}
