package weblab.s17205103.p02;

import org.apache.commons.codec.digest.DigestUtils;
import java.util.*;
import java.io.*;
public class App {
    public static void main(String[] args) throws Exception{
        System.out.println("Input username：");
        Scanner in = new Scanner(System.in);
        String una = in.nextLine();
        System.out.println("password：");
        String ps = in.nextLine();
        if (args.length < 1) {
            System.err.println("Please provide an input!");
            System.exit(0);
        }
        File file = new File("psw.txt");
		InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
        BufferedReader bf = new BufferedReader(inputReader);
        if(bf.readLine().equals(una)&&bf.readLine().equals(sha256hex(ps))){
            System.out.println("验证成功！");
        }else
            System.out.println("验证失败！");
        System.out.println(sha256hex(ps));
    }
    public static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }
}
