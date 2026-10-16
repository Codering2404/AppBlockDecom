package com.google.android.libraries.places.api.model;

import com.google.common.base.Preconditions;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final /* synthetic */ class zzfz implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ zzfz f75342a = new zzfz();

    private /* synthetic */ zzfz() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        int i3 = zzga.f75348c;
        return ((LocalDate) Preconditions.t(((TimeOfWeek) Preconditions.t(((Period) obj).e())).c())).compareTo((LocalDate) Preconditions.t(((TimeOfWeek) Preconditions.t(((Period) obj2).e())).c()));
    }
}
