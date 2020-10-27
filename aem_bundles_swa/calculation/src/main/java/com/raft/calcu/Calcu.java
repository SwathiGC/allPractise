package com.raft.calcu;
import com.raft.add.*;
import com.raft.sub.*;
class Calcu{

	public static void main(String[] args) {
		Add a=new Add();
		System.out.println(a.addValues(1,2));
		Sub s=new Sub();
		System.out.println(s.subValues(2,1));
	}
}