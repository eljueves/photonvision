/*
 * MIT License
 *
 * Copyright (c) PhotonVision
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

// THIS FILE WAS AUTO-GENERATED BY ./photon-serde/generate_messages.py. DO NOT MODIFY

package org.photonvision.struct;

import org.photonvision.common.dataflow.structures.Packet;
import org.photonvision.common.dataflow.structures.PacketSerde;
import org.photonvision.utils.PacketUtils;

// Assume that the base class lives here and we can import it
import org.photonvision.targeting.*;

// WPILib imports (if any)
import edu.wpi.first.util.struct.Struct;


/**
 * Auto-generated serialization/deserialization helper for TargetCorner
 */
public class TargetCornerSerde implements PacketSerde<TargetCorner> {

    @Override
    public final String getInterfaceUUID() { return "16f6ac0dedc8eaccb951f4895d9e18b6"; }
    @Override
    public final String getSchema() { return "float64 x;float64 y;"; }
    @Override
    public final String getTypeName() { return "TargetCorner"; }

    @Override
    public int getMaxByteSize() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMaxByteSize'");
    }

    @Override
    public void pack(Packet packet, TargetCorner value) {
        // field x is of intrinsic type float64
        packet.encode((double) value.x);

        // field y is of intrinsic type float64
        packet.encode((double) value.y);
    }

    @Override
    public TargetCorner unpack(Packet packet) {
        var ret = new TargetCorner();

        // x is of intrinsic type float64
        ret.x = packet.decodeDouble();

        // y is of intrinsic type float64
        ret.y = packet.decodeDouble();

        return ret;
    }

    @Override
    public PacketSerde<?>[] getNestedPhotonMessages() {
        return new PacketSerde<?>[] {
            
        };
    }

    @Override
    public Struct<?>[] getNestedWpilibMessages() {
        return new Struct<?>[] {
            
        };
    }
}
