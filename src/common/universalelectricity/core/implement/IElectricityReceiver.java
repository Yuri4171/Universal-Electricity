package universalelectricity.core.implement;

import net.minecraftforge.common.ForgeDirection;

/**
 * The IElectricityReceiver interface is an interface that must be applied to all TileEntities or
 * Entities that can receive electricity.
 * 
 * @author Calclavia
 * 
 */
public interface IElectricityReceiver extends IDisableable, IConnector, IVoltage
{
	/**
	 * Called every tick on this machine.
	 * 
	 * @param sender
	 *            - Either the TileEntity or the Entity sending the electricity to this
	 *            TileEntity/Entity.
	 * @param amps
	 *            - Amount of amps this electric unit is receiving.
	 * @param voltage
	 *            - The voltage of the electricity sent. If more than one packet is being sent to
	 *            you in this update, the highest voltage will override.
	 * @param side
	 *            - The side of the block in which the electricity is coming from.
	 */
	public void onReceive(Object sender, double amps, double voltage, ForgeDirection side);

	/**
	 * How many watts does this electrical unit need this tick? Recommended for you to return the
	 * max electricity storage of this machine (if there is one).
	 */
	public double wattRequest();

	/**
	 * Can this unit receive electricity from this specific side?
	 */
	public boolean canReceiveFromSide(ForgeDirection side);
}