package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzjo;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ImmutableSet f87678a = ImmutableSet.G("_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ImmutableList f87679b = ImmutableList.G("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ImmutableList f87680c = ImmutableList.B("auto", "app", "am");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ImmutableList f87681d = ImmutableList.A("_r", "_dbg");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ImmutableList f87682e = new ImmutableList.Builder().j(zzjo.f74026a).j(zzjo.f74027b).m();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ImmutableList f87683f = ImmutableList.A("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f87684g = 0;

    public static boolean a(String str) {
        return !f87680c.contains(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean b(String str, Bundle bundle) {
        if (f87679b.contains(str)) {
            return false;
        }
        if (bundle == null) {
            return true;
        }
        ImmutableList immutableList = f87681d;
        int size = immutableList.size();
        int i3 = 0;
        while (i3 < size) {
            boolean zContainsKey = bundle.containsKey((String) immutableList.get(i3));
            i3++;
            if (zContainsKey) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(String str) {
        return !f87678a.contains(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean d(String str, String str2) {
        if ("_ce1".equals(str2) || "_ce2".equals(str2)) {
            return str.equals("fcm") || str.equals("frc");
        }
        if ("_ln".equals(str2)) {
            return str.equals("fcm") || str.equals("fiam");
        }
        if (f87682e.contains(str2)) {
            return false;
        }
        ImmutableList immutableList = f87683f;
        int size = immutableList.size();
        int i3 = 0;
        while (i3 < size) {
            boolean zMatches = str2.matches((String) immutableList.get(i3));
            i3++;
            if (zMatches) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean e(String str, String str2, Bundle bundle) {
        if (!"_cmp".equals(str2)) {
            return true;
        }
        if (!a(str) || bundle == null) {
            return false;
        }
        ImmutableList immutableList = f87681d;
        int size = immutableList.size();
        int i3 = 0;
        while (i3 < size) {
            boolean zContainsKey = bundle.containsKey((String) immutableList.get(i3));
            i3++;
            if (zContainsKey) {
                return false;
            }
        }
        int iHashCode = str.hashCode();
        if (iHashCode != 101200) {
            if (iHashCode != 101230) {
                if (iHashCode == 3142703 && str.equals("fiam")) {
                    bundle.putString("_cis", "fiam_integration");
                    return true;
                }
            } else if (str.equals("fdl")) {
                bundle.putString("_cis", "fdl_integration");
                return true;
            }
        } else if (str.equals("fcm")) {
            bundle.putString("_cis", "fcm_integration");
            return true;
        }
        return false;
    }
}
