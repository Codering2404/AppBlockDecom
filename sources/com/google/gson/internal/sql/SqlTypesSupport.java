package com.google.gson.internal.sql;

import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import java.sql.Date;
import java.sql.Timestamp;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class SqlTypesSupport {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f90536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DefaultDateTypeAdapter.DateType f90537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final DefaultDateTypeAdapter.DateType f90538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TypeAdapterFactory f90539d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final TypeAdapterFactory f90540e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final TypeAdapterFactory f90541f;

    static {
        boolean z2;
        try {
            Class.forName("java.sql.Date");
            z2 = true;
        } catch (ClassNotFoundException unused) {
            z2 = false;
        }
        f90536a = z2;
        if (z2) {
            f90537b = new DefaultDateTypeAdapter.DateType<Date>(Date.class) { // from class: com.google.gson.internal.sql.SqlTypesSupport.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.gson.internal.bind.DefaultDateTypeAdapter.DateType
                /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
                public Date d(java.util.Date date) {
                    return new Date(date.getTime());
                }
            };
            f90538c = new DefaultDateTypeAdapter.DateType<Timestamp>(Timestamp.class) { // from class: com.google.gson.internal.sql.SqlTypesSupport.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.gson.internal.bind.DefaultDateTypeAdapter.DateType
                /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
                public Timestamp d(java.util.Date date) {
                    return new Timestamp(date.getTime());
                }
            };
            f90539d = SqlDateTypeAdapter.f90530b;
            f90540e = SqlTimeTypeAdapter.f90532b;
            f90541f = SqlTimestampTypeAdapter.f90534b;
            return;
        }
        f90537b = null;
        f90538c = null;
        f90539d = null;
        f90540e = null;
        f90541f = null;
    }
}
