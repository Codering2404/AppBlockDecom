package com.applovin.impl;

import android.opengl.GLES20;
import com.applovin.impl.ci;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class ei {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String[] f59496j = {"uniform mat4 uMvpMatrix;", "uniform mat3 uTexMatrix;", "attribute vec4 aPosition;", "attribute vec2 aTexCoords;", "varying vec2 vTexCoords;", "void main() {", "  gl_Position = uMvpMatrix * aPosition;", "  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;", "}"};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String[] f59497k = {"#extension GL_OES_EGL_image_external : require", "precision mediump float;", "uniform samplerExternalOES uTexture;", "varying vec2 vTexCoords;", "void main() {", "  gl_FragColor = texture2D(uTexture, vTexCoords);", "}"};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final float[] f59498l = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final float[] f59499m = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final float[] f59500n = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final float[] f59501o = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final float[] f59502p = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.5f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f59503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f59504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f59505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f59506d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f59507e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f59508f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f59509g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f59510h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f59511i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f59512a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final FloatBuffer f59513b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final FloatBuffer f59514c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f59515d;

        public a(ci.b bVar) {
            this.f59512a = bVar.a();
            this.f59513b = aa.a(bVar.f58915c);
            this.f59514c = aa.a(bVar.f58916d);
            int i3 = bVar.f58914b;
            if (i3 == 1) {
                this.f59515d = 5;
            } else if (i3 != 2) {
                this.f59515d = 4;
            } else {
                this.f59515d = 6;
            }
        }
    }

    ei() {
    }

    void a(int i3, float[] fArr, boolean z2) {
        a aVar = z2 ? this.f59505c : this.f59504b;
        if (aVar == null) {
            return;
        }
        GLES20.glUseProgram(this.f59506d);
        aa.a();
        GLES20.glEnableVertexAttribArray(this.f59509g);
        GLES20.glEnableVertexAttribArray(this.f59510h);
        aa.a();
        int i4 = this.f59503a;
        GLES20.glUniformMatrix3fv(this.f59508f, 1, false, i4 == 1 ? z2 ? f59500n : f59499m : i4 == 2 ? z2 ? f59502p : f59501o : f59498l, 0);
        GLES20.glUniformMatrix4fv(this.f59507e, 1, false, fArr, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i3);
        GLES20.glUniform1i(this.f59511i, 0);
        aa.a();
        GLES20.glVertexAttribPointer(this.f59509g, 3, 5126, false, 12, (Buffer) aVar.f59513b);
        aa.a();
        GLES20.glVertexAttribPointer(this.f59510h, 2, 5126, false, 8, (Buffer) aVar.f59514c);
        aa.a();
        GLES20.glDrawArrays(aVar.f59515d, 0, aVar.f59512a);
        aa.a();
        GLES20.glDisableVertexAttribArray(this.f59509g);
        GLES20.glDisableVertexAttribArray(this.f59510h);
    }

    public void b(ci ciVar) {
        if (a(ciVar)) {
            this.f59503a = ciVar.f58910c;
            a aVar = new a(ciVar.f58908a.a(0));
            this.f59504b = aVar;
            if (!ciVar.f58911d) {
                aVar = new a(ciVar.f58909b.a(0));
            }
            this.f59505c = aVar;
        }
    }

    void a() {
        int iA = aa.a(f59496j, f59497k);
        this.f59506d = iA;
        this.f59507e = GLES20.glGetUniformLocation(iA, "uMvpMatrix");
        this.f59508f = GLES20.glGetUniformLocation(this.f59506d, "uTexMatrix");
        this.f59509g = GLES20.glGetAttribLocation(this.f59506d, "aPosition");
        this.f59510h = GLES20.glGetAttribLocation(this.f59506d, "aTexCoords");
        this.f59511i = GLES20.glGetUniformLocation(this.f59506d, "uTexture");
    }

    public static boolean a(ci ciVar) {
        ci.a aVar = ciVar.f58908a;
        ci.a aVar2 = ciVar.f58909b;
        return aVar.a() == 1 && aVar.a(0).f58913a == 0 && aVar2.a() == 1 && aVar2.a(0).f58913a == 0;
    }
}
