package com.google.crypto.tink.subtle;

import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import java.util.Arrays;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class AesSiv implements DeterministicAead {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TinkFipsUtil.AlgorithmFipsCompatibility f87377a = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Collection f87378b = Arrays.asList(64);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final byte[] f87379c = new byte[16];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final byte[] f87380d = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
}
