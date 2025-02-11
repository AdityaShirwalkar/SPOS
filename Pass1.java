import java.io.*;
import java.util.*;

class Pass1 {
    Vector<String> mnt = new Vector<>();
    Vector<String> mdt = new Vector<>();
    Vector<String> ala = new Vector<>();
    Vector<Integer> argu = new Vector<>();
    int hit = 0;
    int prev = 0;
    int length = 0;
    String line;
    int p = 0;
    int flag = 0;
    int k = 0;

    void scan() {
        try (Scanner scanner = new Scanner(new FileReader("input.txt"))) {
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                length++;
                String[] temp = line.split("[,\\s+]");
                for (int i = 0; i < temp.length; i++) {
                    if (temp[0].equals("MACRO") || temp[0].equals("MEND")) {
                        length--;
                    }
                    if (i == 0 && temp[0].equals("MACRO")) {
                        p = 1;
                        break;
                    }
                    if (p == 1) {
                        prev = hit;
                        if (!argu.contains(prev)) {
                            argu.add(prev);
                        }
                        mnt.add(temp[0]);
                        mnt.add(Integer.toString(length));
                        for (int j = 1; j < temp.length; j++) {
                            ala.add(temp[j]);
                            hit++;
                        }
                        if (!argu.contains(hit)) {
                            argu.add(hit);
                        }
                        p = 0;
                    }
                    if (i == 0 && temp[0].equals("MEND")) {
                        flag = 1;
                        mdt.add(temp[i]);
                    }
                    if (i > 0 && !temp[i - 1].equals("MACRO") && !mnt.contains(temp[i - 1])
                            && temp[i].startsWith("&")) {
                        StringBuilder t = new StringBuilder();
                        int l = 0;
                        for (int h = 0; h < temp.length; h++) {
                            if (mnt.contains(temp[0])) {
                                l = 1;
                            }
                            if (!temp[h].startsWith("&") && l == 0) {
                                t.append(temp[h]);
                            } else {
                                if (l == 0) {
                                    if (flag == 0) {
                                        for (int g = 0; g < ala.size(); g++) {
                                            if (ala.get(g).equals(temp[h])) {
                                                k = g + 1;
                                            }
                                        }
                                    } else {
                                        for (int g = prev; g < ala.size(); g++) {
                                            if (ala.get(g).equals(temp[h])) {
                                                k = g + 1;
                                            }
                                        }
                                    }
                                    t.append("\t#").append(k);
                                }
                            }
                        }
                        if (t.length() > 1) {
                            mdt.add(t.toString());
                        }
                        i++;
                    }
                }
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("ala.txt"))) {
                for (int i = 0; i < ala.size(); i++) {
                    writer.write((i + 1) + "\t" + ala.get(i) + "\n");
                }
            } catch (IOException e) {
                System.out.println("Could no write to file ala.txt");
                e.printStackTrace();
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("mnt.txt"))) {
                int j = 1;
                for (int i = 0; i < mnt.size(); i = i + 2) {
                    writer.write(j + "\t" + mnt.get(i) + "\t" + mnt.get((i + 1)) + "\n");
                    j++;
                }
            } catch (IOException e) {
                System.out.println("Could not write to file mnt.txt");
                e.printStackTrace();
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("mdt.txt"))) {
                for (int i = 0; i < mdt.size(); i++) {
                    writer.write((i + 1) + "\t" + mdt.get(i) + "\n");
                }
            } catch (IOException e) {
                System.out.println("Could nnot write to file mdt.txt");
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File input.txt not found");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Pass1 t = new Pass1();
        t.scan();
    }
}