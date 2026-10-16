package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.data.Entry;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class EntryXComparator implements Comparator<Entry> {
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Entry entry, Entry entry2) {
        float fH = entry.h() - entry2.h();
        if (fH == 0.0f) {
            return 0;
        }
        return fH > 0.0f ? 1 : -1;
    }
}
