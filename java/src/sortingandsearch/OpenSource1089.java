/** 
* Judge Online: Caribbean Online Judge. 
* URL: http://coj.uci.cu/24h/problem.xhtml?pid=1089
* Problem: 1089 - Open Source
* Description 
* 
* At an open-source fair held at a major university, leaders of open-source projects put sign-up 
* sheets on the wall, with the project name at the top in capital letters for identification. Students
* then signed up for projects using their userids. A userid is a string of lower-case letters and numbers
* starting with a letter. The organizer then took all the sheets off the wall and typed in the information.
* Your job is to summarize the number of students who have signed up for each project. Some students were overly
* enthusiastic and put their name down several times for the same project. That's okay, but they should only count
* once. Students were asked to commit to a single project, so any student who has signed up for more than one project
* should not count for any project. There are at most 10000 students at the university, and at most 100 projects
* were advertised.
**/ 
package sortingandsearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author iromeroga
 */
public class OpenSource1089 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);

    public static void main(String[] args) throws IOException {
        String line;
        ArrayList<Proyecto> proyectos = new ArrayList<>();
        OUTER:
        while (true) {
            line = br.readLine();
            switch (line) {
                case "0":
                    break OUTER;
                case "1":
                    Collections.sort(proyectos, new Comparator<Proyecto>() {
                        @Override
                        public int compare(Proyecto o1, Proyecto o2) {
                            if (o1.userProySet.size() > o2.userProySet.size()) {
                                return -1;
                            } else if (o1.userProySet.size() < o2.userProySet.size()) {
                                return 1;
                            } else if (o1.userProySet.size() == o2.userProySet.size()) {
                                return o1.proy.compareTo(o2.proy);
                            }
                            return 0;
                        }
                    });
                    for (int i = 0; i < proyectos.size(); i++) {
                        bw.append(proyectos.get(i).proy + " " + proyectos.get(i).userProySet.size() + "\n");
                    }
                    proyectos.clear();
                    Proyecto.refresh();
                    break;
                default:
                    if ((line.charAt(0) + "").matches("[A-Z]+")) {
                        Proyecto proyecto = new Proyecto(line);
                        Proyecto.proInt++;
                        proyectos.add(proyecto);
                    } else if ((line.charAt(0) + "").matches("[a-z]+")) {
                        if (!Proyecto.userSet.contains(line)) {
                            proyectos.get(Proyecto.proInt).userProySet.add(line);
                            Proyecto.userSet.add(line);
                        } else {
                            for (int i = 0; i < proyectos.size() - 1; i++) {
                                if (proyectos.get(i).userProySet.contains(line)) {
                                    proyectos.get(i).userProySet.remove(line);
                                }
                            }
                        }
                    }
                    break;
            }
        }
        bw.flush();
        bw.close();
    }

    public static class Proyecto {

        public static Set<String> userSet;
        public Set userProySet;
        public String proy;
        public static int proInt;

        public Proyecto(String name) {
            this.proy = name;
            userProySet = new TreeSet();
            createIntance();
        }

        private void createIntance() {
            if (userSet == null) {
                proInt = -1;
                userSet = new TreeSet<>();
            }
        }

        public static void refresh() {
            userSet.clear();
            proInt = -1;
        }

    }

}
