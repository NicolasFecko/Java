public class Geometry {
    public static float obsahObdlznika(float stranaA, float stranaB){
        return (stranaA*stranaB);
    }

    public static float obsahKruhu(float polomer){
        return (float) (Math.PI*polomer*polomer);
    }

    public static float obvodTrojuholnika(float a, float b, float c){
        return (a+b+c);
    }

    public static boolean jeTrojuholnikPlatny(float a, float b, float c){
        if (a+b>c && a+c>b&&b+c>a){

            return true;
        }
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(obsahObdlznika(0,0));
        System.out.println(obsahKruhu(1));
        System.out.println(obvodTrojuholnika(1,2,3));
        System.out.println(jeTrojuholnikPlatny(1,5,7));


    }
}