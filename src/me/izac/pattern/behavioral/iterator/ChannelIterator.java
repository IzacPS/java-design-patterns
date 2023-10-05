package me.izac.pattern.behavioral.iterator;

public interface ChannelIterator {

	boolean hasNext();
	
	Channel next();
}