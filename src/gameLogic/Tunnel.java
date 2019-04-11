package gameLogic;

import java.util.*;

/**
 * This class is responsible for the tunnels which connect the two entrances.
 */
class Tunnel extends Segment {

	 /**
     * This constructor assigns the entrances.
     */

	public Tunnel(TunnelEntrance entrance1, TunnelEntrance entrance2) {
		this.entrance0 = entrance1;
		this.entrance1 = entrance2;

	}

	/**
	 * This attribute stores one entrance of the tunnel.
	 */
	protected TunnelEntrance entrance0;

	/**
	 * This attribute stores another entrance of the tunnel.
	 */
	protected TunnelEntrance entrance1;

	/**
	 * This method returns the other end of the tunnel
	 * passed on to this method as te.
	 */
	public TunnelEntrance GetTheOtherEnd(TunnelEntrance te) {
		System.out.println("\t>GetOtherEnd(te1): Gets the second entrance we selected.");
		if (te == entrance0) {
			System.out.println("\t<GetOtherEnd(te1): Returns a reference to another entrance. te2 in this case.");
			return entrance1;
		}
		if (te == entrance1) {
			System.out.println("\t<GetOtherEnd(te1): Returns a reference to another entrance. te2 in this case.");
			return entrance0;
		}
		System.out.println("\t<GetOtherEnd(te1): Returns a reference to another entrance. te2 in this case.");
		return null;
	}

}