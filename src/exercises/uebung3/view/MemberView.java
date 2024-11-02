package exercises.uebung3.view;

import exercises.uebung3.control.Member;

import java.util.List;

public class MemberView {
     public void dump(List<Member> liste){
         System.out.println("Ausgabe aller Member-Objekte: ");
         for(Member member : liste){
             System.out.println("ID: " + member.toString());
         }
     }
}
