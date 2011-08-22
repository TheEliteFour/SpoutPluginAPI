/*
 * This file is part of Spout API (http://wiki.getspout.org/).
 * 
 * Spout API is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Spout API is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.getspout.spoutapi.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class PacketStopMusic implements SpoutPacket{
	private boolean resetTimer = false;
	private int fadeTime = -1;
	public PacketStopMusic() {
		
	}
	
	public PacketStopMusic(boolean resetTimer, int fadeTime) {
		this.resetTimer = resetTimer;
		this.fadeTime = fadeTime;
	}

	@Override
	public int getNumBytes() {
		return 5;
	}

	@Override
	public void readData(DataInputStream input) throws IOException {
		resetTimer = input.readBoolean();
		fadeTime = input.readInt();
	}

	@Override
	public void writeData(DataOutputStream output) throws IOException {
		output.writeBoolean(resetTimer);
		output.writeInt(fadeTime);
	}

	@Override
	public void run(int PlayerId) {
		
	}

	@Override
	public void failure(int id) {
		
	}

	@Override
	public PacketType getPacketType() {
		return PacketType.PacketStopMusic;
	}
	
	@Override
	public int getVersion() {
		return 0;
	}

}
