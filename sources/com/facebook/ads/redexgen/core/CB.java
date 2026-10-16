package com.facebook.ads.redexgen.core;

import com.google.common.base.ElementTypesAreNonnullByDefault;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@ElementTypesAreNonnullByDefault
public abstract class CB extends AbstractC1855kK {
    public static int A00(@CheckForNull Object... objects) {
        return Arrays.hashCode(objects);
    }

    public static boolean A01(@CheckForNull Object a3, @CheckForNull Object b3) {
        return a3 == b3 || (a3 != null && a3.equals(b3));
    }
}
