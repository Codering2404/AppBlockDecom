package com.applovin.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.applovin.impl.r5;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class j6 implements ti {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f60610a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f60613d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f60615f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f60616g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f60617h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f60618i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f60619j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f60620k;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f60611b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f60612c = 5000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ld f60614e = ld.f61193a;

    public j6(Context context) {
        this.f60610a = context;
    }

    protected void a(Context context, Handler handler, int i3, ArrayList arrayList) {
    }

    protected void a(Context context, int i3, ld ldVar, boolean z2, r1 r1Var, Handler handler, q1 q1Var, ArrayList arrayList) {
        int i4;
        int i5;
        hd hdVar = new hd(context, ldVar, z2, handler, q1Var, r1Var);
        hdVar.a(this.f60615f);
        hdVar.b(this.f60616g);
        hdVar.c(this.f60617h);
        arrayList.add(hdVar);
        if (i3 == 0) {
            return;
        }
        int size = arrayList.size();
        if (i3 == 2) {
            size--;
        }
        try {
            try {
                i4 = size + 1;
            } catch (ClassNotFoundException unused) {
            }
            try {
                arrayList.add(size, (qi) Class.forName("com.applovin.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(Handler.class, q1.class, r1.class).newInstance(handler, q1Var, r1Var));
                oc.c("DefaultRenderersFactory", "Loaded LibopusAudioRenderer.");
            } catch (ClassNotFoundException unused2) {
                size = i4;
                i4 = size;
            }
            try {
                try {
                    i5 = i4 + 1;
                } catch (ClassNotFoundException unused3) {
                }
                try {
                    arrayList.add(i4, (qi) Class.forName("com.applovin.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, q1.class, r1.class).newInstance(handler, q1Var, r1Var));
                    oc.c("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                } catch (ClassNotFoundException unused4) {
                    i4 = i5;
                    i5 = i4;
                }
                try {
                    arrayList.add(i5, (qi) Class.forName("com.applovin.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, q1.class, r1.class).newInstance(handler, q1Var, r1Var));
                    oc.c("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                } catch (ClassNotFoundException unused5) {
                } catch (Exception e3) {
                    throw new RuntimeException("Error instantiating FFmpeg extension", e3);
                }
            } catch (Exception e4) {
                throw new RuntimeException("Error instantiating FLAC extension", e4);
            }
        } catch (Exception e5) {
            throw new RuntimeException("Error instantiating Opus extension", e5);
        }
    }

    protected void a(Context context, int i3, ArrayList arrayList) {
        arrayList.add(new w2());
    }

    protected void a(Context context, ef efVar, Looper looper, int i3, ArrayList arrayList) {
        arrayList.add(new ff(efVar, looper));
    }

    protected void a(Context context, ao aoVar, Looper looper, int i3, ArrayList arrayList) {
        arrayList.add(new bo(aoVar, looper));
    }

    protected void a(Context context, int i3, ld ldVar, boolean z2, Handler handler, wq wqVar, long j3, ArrayList arrayList) {
        String str;
        Integer num;
        int i4;
        int i5;
        Class cls = Integer.TYPE;
        Class cls2 = Long.TYPE;
        od odVar = new od(context, ldVar, j3, z2, handler, wqVar, 50);
        odVar.a(this.f60615f);
        odVar.b(this.f60616g);
        odVar.c(this.f60617h);
        arrayList.add(odVar);
        if (i3 == 0) {
            return;
        }
        int size = arrayList.size();
        if (i3 == 2) {
            size--;
        }
        try {
            try {
                Constructor<?> constructor = Class.forName("com.applovin.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(cls2, Handler.class, wq.class, cls);
                num = 50;
                try {
                    i4 = size + 1;
                    try {
                        arrayList.add(size, (qi) constructor.newInstance(Long.valueOf(j3), handler, wqVar, 50));
                        str = "DefaultRenderersFactory";
                        try {
                            oc.c(str, "Loaded LibvpxVideoRenderer.");
                        } catch (ClassNotFoundException unused) {
                            size = i4;
                            i4 = size;
                        }
                    } catch (ClassNotFoundException unused2) {
                        str = "DefaultRenderersFactory";
                    }
                } catch (ClassNotFoundException unused3) {
                    str = "DefaultRenderersFactory";
                }
            } catch (ClassNotFoundException unused4) {
                str = "DefaultRenderersFactory";
                num = 50;
            }
            try {
                try {
                    i5 = i4 + 1;
                } catch (ClassNotFoundException unused5) {
                }
                try {
                    arrayList.add(i4, (qi) Class.forName("com.applovin.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(cls2, Handler.class, wq.class, cls).newInstance(Long.valueOf(j3), handler, wqVar, num));
                    oc.c(str, "Loaded Libgav1VideoRenderer.");
                } catch (ClassNotFoundException unused6) {
                    i4 = i5;
                    i5 = i4;
                }
                try {
                    arrayList.add(i5, (qi) Class.forName("com.applovin.exoplayer2.ext.ffmpeg.FfmpegVideoRenderer").getConstructor(cls2, Handler.class, wq.class, cls).newInstance(Long.valueOf(j3), handler, wqVar, num));
                    oc.c(str, "Loaded FfmpegVideoRenderer.");
                } catch (ClassNotFoundException unused7) {
                } catch (Exception e3) {
                    throw new RuntimeException("Error instantiating FFmpeg extension", e3);
                }
            } catch (Exception e4) {
                throw new RuntimeException("Error instantiating AV1 extension", e4);
            }
        } catch (Exception e5) {
            throw new RuntimeException("Error instantiating VP9 extension", e5);
        }
    }

    @Override // com.applovin.impl.ti
    public qi[] a(Handler handler, wq wqVar, q1 q1Var, ao aoVar, ef efVar) {
        Handler handler2;
        ArrayList arrayList = new ArrayList();
        a(this.f60610a, this.f60611b, this.f60614e, this.f60613d, handler, wqVar, this.f60612c, arrayList);
        r1 r1VarA = a(this.f60610a, this.f60618i, this.f60619j, this.f60620k);
        if (r1VarA != null) {
            handler2 = handler;
            a(this.f60610a, this.f60611b, this.f60614e, this.f60613d, r1VarA, handler2, q1Var, arrayList);
        } else {
            handler2 = handler;
        }
        a(this.f60610a, aoVar, handler2.getLooper(), this.f60611b, arrayList);
        a(this.f60610a, efVar, handler2.getLooper(), this.f60611b, arrayList);
        a(this.f60610a, this.f60611b, arrayList);
        a(this.f60610a, handler2, this.f60611b, arrayList);
        return (qi[]) arrayList.toArray(new qi[0]);
    }

    protected r1 a(Context context, boolean z2, boolean z3, boolean z4) {
        return new r5(n1.a(context), new r5.d(new p1[0]), z2, z3, z4 ? 1 : 0);
    }
}
