package d13;

import java.util.ArrayList;
import java.util.List;


public class Packet implements Comparable<Packet> {
	private static final char COMMA = ',';
	private static final char LEFT_BRACKET = '[';
	private static final char RIGHT_BRACKET = ']';
	private String message;
	private List<Packet> subPackets = new ArrayList<>();
	private boolean isInteger = true;
	
	private int value;
	
	public Packet(String input) {
		init(input);
	}
	
	private void init(String input) {
		this.message = input;
		if (input.charAt(0) != LEFT_BRACKET) {
			value = Integer.parseInt(message);
		} else {
			divideListToPackets(message);
		}
	}
	
	private void divideListToPackets(String message) {
		message = message.substring(1, message.length() - 1);
		isInteger = false;
		int depth = 0;
		StringBuilder stringBuilder = new StringBuilder();
		for (final char c : message.toCharArray()) {
			if (depth == 0 && c == COMMA) {
				subPackets.add(new Packet(stringBuilder.toString()));
				stringBuilder = new StringBuilder();
			} else {
				// Keep adding to subpacket, keeping track of depth
				if (c == LEFT_BRACKET) {
					depth++;
				} else if (c == RIGHT_BRACKET) {
					depth--;
				}
				stringBuilder.append(c);
			}
		}
		if (!stringBuilder.isEmpty()) {
			subPackets.add(new Packet(stringBuilder.toString()));
		}
	}
	
	@Override
	public int compareTo(Packet packet) {
		if (this.isInteger && packet.isInteger) {
			return Integer.compare(this.getValue(), packet.getValue());
		} else if (!this.isInteger && !packet.isInteger) {
			for (int i = 0; i < Math.min(this.getSubPackets().size(), packet.getSubPackets().size()); i++) {
				final int comparisionOutput = this.getSubPackets().get(i).compareTo(packet.getSubPackets().get(i));
				if (comparisionOutput != 0) {
					return comparisionOutput;
				}
			}
			return Integer.compare(this.getSubPackets().size(), packet.getSubPackets().size());
		} else if (this.isInteger()) {
			return convertIntPacket(this.getValue()).compareTo(packet);
		} else {
			return this.compareTo(convertIntPacket(packet.getValue()));
		}
	}
	
	private Packet convertIntPacket(int data) {
		StringBuilder builder = new StringBuilder();
		String str = builder.append(LEFT_BRACKET)
				.append(data)
				.append(RIGHT_BRACKET)
				.toString();
		return new Packet(str);
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public List<Packet> getSubPackets() {
		return subPackets;
	}
	
	public void setSubPackets(List<Packet> subPackets) {
		this.subPackets = subPackets;
	}
	
	public boolean isInteger() {
		return isInteger;
	}
	
	public void setInteger(boolean integer) {
		isInteger = integer;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
}
