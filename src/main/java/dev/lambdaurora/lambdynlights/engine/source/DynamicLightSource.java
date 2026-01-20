/*
 * Copyright © 2024 LambdAurora <email@lambdaurora.dev>
 *
 * This file is part of LambDynamicLights.
 *
 * Licensed under the Lambda License. For more information,
 * see the LICENSE file.
 */

package dev.lambdaurora.lambdynlights.engine.source;

import dev.lambdaurora.lambdynlights.engine.CellHasher;
import dev.lambdaurora.lambdynlights.engine.lookup.SpatialLookupEntry;
import dev.lambdaurora.lambdynlights.engine.scheduler.ChunkRebuildStatus;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.SectionPos;
import net.minecraft.util.Mth;

import java.util.function.LongConsumer;
import java.util.stream.Stream;

/**
 * Represents a dynamic light source.
 *
 * @author LambdAurora
 * @version 4.8.0
 * @since 4.0.0
 */
public interface DynamicLightSource {
	/**
	 * {@return the identifier of this dynamic light source, may not be unique}
	 */
	int getDynamicLightId();

	/**
	 * Splits this dynamic light source into spatial lookup entries.
	 *
	 * @param cellHasher the cell hasher
	 * @return a stream of spatial lookup entries this source is made of
	 */
	Stream<SpatialLookupEntry> splitIntoDynamicLightEntries(CellHasher cellHasher);

	/**
	 * Computes the map of chunk sections to rebuild to display in-world the new light values.
	 *
	 * @param forced {@code true} if relevant chunk sections must be returned to rebuild the chunk sections (for example if the light source is removed),
	 * or {@code false} otherwise
	 * @return the map of chunk sections to rebuild, or an empty map if none is to be rebuilt
	 */
	Long2ObjectMap<ChunkRebuildStatus> getDynamicLightChunksToRebuild(boolean forced);

	/**
	 * Gathers the closest chunks from the given coordinates.
	 *
	 * @param x the X-coordinate
	 * @param y the Y-coordinate
	 * @param z the Z-coordinate
	 * @param chunkConsumer the consumer of the relevant chunks
	 */
	static void gatherClosestChunks(double x, double y, double z, LongConsumer chunkConsumer) {
		var chunkPos = new BlockPos.MutableBlockPos(
				SectionPos.blockToSectionCoord(x),
				SectionPos.blockToSectionCoord(y),
				SectionPos.blockToSectionCoord(z)
		);
			
		chunkPos.move(Direction.WEST);
		chunkConsumer.accept(SectionPos.asLong(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ()));
		chunkPos.move(Direction.NORTH);
		chunkConsumer.accept(SectionPos.asLong(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ()));
		chunkPos.move(Direction.EAST);
		chunkConsumer.accept(SectionPos.asLong(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ()));
		chunkPos.move(Direction.EAST);
		chunkConsumer.accept(SectionPos.asLong(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ()));
		chunkPos.move(Direction.SOUTH);
		chunkConsumer.accept(SectionPos.asLong(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ()));
		chunkPos.move(Direction.SOUTH);
		chunkConsumer.accept(SectionPos.asLong(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ()));
		chunkPos.move(Direction.WEST);
		chunkConsumer.accept(SectionPos.asLong(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ()));
		chunkPos.move(Direction.WEST);
		chunkConsumer.accept(SectionPos.asLong(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ()));
		chunkPos.move(Direction.UP);
		chunkConsumer.accept(SectionPos.asLong(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ()));
		chunkPos.move(Direction.NORTH);
		chunkConsumer.accept(SectionPos.asLong(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ()));
		chunkPos.move(Direction.NORTH);
		chunkConsumer.accept(SectionPos.asLong(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ()));
		chunkPos.move(Direction.EAST);
		chunkConsumer.accept(SectionPos.asLong(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ()));
		chunkPos.move(Direction.EAST);
		chunkConsumer.accept(SectionPos.asLong(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ()));
		chunkPos.move(Direction.SOUTH);
		chunkConsumer.accept(SectionPos.asLong(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ()));
		chunkPos.move(Direction.SOUTH);
		chunkConsumer.accept(SectionPos.asLong(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ()));
		chunkPos.move(Direction.WEST);
		chunkConsumer.accept(SectionPos.asLong(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ()));
		chunkPos.move(Direction.NORTH);
		chunkConsumer.accept(SectionPos.asLong(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ()));
		chunkPos.move(Direction.DOWN);
		chunkConsumer.accept(SectionPos.asLong(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ()));
		chunkPos.move(Direction.DOWN);
		chunkConsumer.accept(SectionPos.asLong(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ()));
		chunkPos.move(Direction.WEST);
		chunkConsumer.accept(SectionPos.asLong(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ()));
		chunkPos.move(Direction.NORTH);
		chunkConsumer.accept(SectionPos.asLong(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ()));
		chunkPos.move(Direction.EAST);
		chunkConsumer.accept(SectionPos.asLong(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ()));
		chunkPos.move(Direction.EAST);
		chunkConsumer.accept(SectionPos.asLong(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ()));
		chunkPos.move(Direction.SOUTH);
		chunkConsumer.accept(SectionPos.asLong(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ()));
		chunkPos.move(Direction.SOUTH);
		chunkConsumer.accept(SectionPos.asLong(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ()));
		chunkPos.move(Direction.WEST);
		chunkConsumer.accept(SectionPos.asLong(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ()));
		chunkPos.move(Direction.WEST);
		chunkConsumer.accept(SectionPos.asLong(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ()));
		}
	}
}
