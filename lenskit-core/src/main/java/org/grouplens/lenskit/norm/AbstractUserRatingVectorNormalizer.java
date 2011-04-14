/*
 * LensKit, a reference implementation of recommender algorithms.
 * Copyright 2010-2011 Regents of the University of Minnesota
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package org.grouplens.lenskit.norm;

import org.grouplens.lenskit.data.vector.MutableSparseVector;
import org.grouplens.lenskit.data.vector.SparseVector;

/**
 * @author Michael Ekstrand <ekstrand@cs.umn.edu>
 *
 */
public abstract class AbstractUserRatingVectorNormalizer implements
        UserRatingVectorNormalizer {

    /**
     * Implementation that delegates to {@link #makeTransformation(long, SparseVector)}
     * and the resulting {@link VectorTransformation}.
     */
    @Override
    public void normalize(long userId, SparseVector ratings,
            MutableSparseVector vector) {
        VectorTransformation tform = makeTransformation(userId, ratings);
        tform.apply(vector);
    }

    /**
     * Implementation that delegates to {@link #normalize(long, SparseVector, MutableSparseVector)}.
     */
    @Override
    public void normalize(long userId, MutableSparseVector ratings) {
        normalize(userId, ratings, ratings);
    }
}