package androidx.media3.common.util;

import android.content.Context;
import android.opengl.GLES20;
import androidx.media3.common.util.GlUtil;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class GlProgram {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f41513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Attribute[] f41514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Uniform[] f41515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f41516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map f41517e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f41518f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Attribute {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f41519a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f41520b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Buffer f41521c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f41522d;

        private Attribute(String str, int i3) {
            this.f41519a = str;
            this.f41520b = i3;
        }

        public static Attribute b(int i3, int i4) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i3, 35722, iArr, 0);
            int i5 = iArr[0];
            byte[] bArr = new byte[i5];
            GLES20.glGetActiveAttrib(i3, i4, i5, new int[1], 0, new int[1], 0, new int[1], 0, bArr, 0);
            String str = new String(bArr, 0, GlProgram.j(bArr));
            return new Attribute(str, GlProgram.h(i3, str));
        }

        public void a() throws GlUtil.GlException {
            Buffer buffer = (Buffer) Assertions.f(this.f41521c, "call setBuffer before bind");
            GLES20.glBindBuffer(34962, 0);
            GLES20.glVertexAttribPointer(this.f41520b, this.f41522d, 5126, false, 0, buffer);
            GLES20.glEnableVertexAttribArray(this.f41520b);
            GlUtil.e();
        }

        public void c(float[] fArr, int i3) {
            this.f41521c = GlUtil.j(fArr);
            this.f41522d = i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Uniform {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f41523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f41524b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f41525c;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f41528f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f41529g;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float[] f41526d = new float[16];

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int[] f41527e = new int[4];

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f41530h = 9729;

        private Uniform(String str, int i3, int i4) {
            this.f41523a = str;
            this.f41524b = i3;
            this.f41525c = i4;
        }

        public static Uniform b(int i3, int i4) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i3, 35719, iArr, 0);
            int[] iArr2 = new int[1];
            int i5 = iArr[0];
            byte[] bArr = new byte[i5];
            GLES20.glGetActiveUniform(i3, i4, i5, new int[1], 0, new int[1], 0, iArr2, 0, bArr, 0);
            String str = new String(bArr, 0, GlProgram.j(bArr));
            return new Uniform(str, GlProgram.k(i3, str), iArr2[0]);
        }

        public void a(boolean z2) throws GlUtil.GlException {
            int i3 = this.f41525c;
            if (i3 == 5124) {
                GLES20.glUniform1iv(this.f41524b, 1, this.f41527e, 0);
                GlUtil.e();
                return;
            }
            if (i3 == 5126) {
                GLES20.glUniform1fv(this.f41524b, 1, this.f41526d, 0);
                GlUtil.e();
                return;
            }
            if (i3 == 35678 || i3 == 35815 || i3 == 36198) {
                if (this.f41528f == 0) {
                    throw new IllegalStateException("No call to setSamplerTexId() before bind.");
                }
                GLES20.glActiveTexture(this.f41529g + 33984);
                GlUtil.e();
                int i4 = this.f41525c;
                GlUtil.b(i4 == 35678 ? 3553 : 36197, this.f41528f, (i4 == 35678 || !z2) ? 9729 : 9728);
                if (this.f41525c == 35678) {
                    if (this.f41530h == 9987) {
                        GLES20.glGenerateMipmap(3553);
                        GlUtil.e();
                    }
                    GLES20.glTexParameteri(3553, 10241, this.f41530h);
                    GlUtil.e();
                }
                GLES20.glUniform1i(this.f41524b, this.f41529g);
                GlUtil.e();
                return;
            }
            switch (i3) {
                case 35664:
                    GLES20.glUniform2fv(this.f41524b, 1, this.f41526d, 0);
                    GlUtil.e();
                    return;
                case 35665:
                    GLES20.glUniform3fv(this.f41524b, 1, this.f41526d, 0);
                    GlUtil.e();
                    return;
                case 35666:
                    GLES20.glUniform4fv(this.f41524b, 1, this.f41526d, 0);
                    GlUtil.e();
                    return;
                case 35667:
                    GLES20.glUniform2iv(this.f41524b, 1, this.f41527e, 0);
                    GlUtil.e();
                    return;
                case 35668:
                    GLES20.glUniform3iv(this.f41524b, 1, this.f41527e, 0);
                    GlUtil.e();
                    return;
                case 35669:
                    GLES20.glUniform4iv(this.f41524b, 1, this.f41527e, 0);
                    GlUtil.e();
                    return;
                default:
                    switch (i3) {
                        case 35675:
                            GLES20.glUniformMatrix3fv(this.f41524b, 1, false, this.f41526d, 0);
                            GlUtil.e();
                            return;
                        case 35676:
                            GLES20.glUniformMatrix4fv(this.f41524b, 1, false, this.f41526d, 0);
                            GlUtil.e();
                            return;
                        default:
                            throw new IllegalStateException("Unexpected uniform type: " + this.f41525c);
                    }
            }
        }

        public void c(float f3) {
            this.f41526d[0] = f3;
        }

        public void d(float[] fArr) {
            System.arraycopy(fArr, 0, this.f41526d, 0, fArr.length);
        }

        public void e(int i3) {
            this.f41527e[0] = i3;
        }

        public void f(int i3, int i4) {
            this.f41528f = i3;
            this.f41529g = i4;
        }

        public void g(int i3) {
            this.f41530h = i3;
        }
    }

    public GlProgram(Context context, String str, String str2) {
        this(Util.K0(context, str), Util.K0(context, str2));
    }

    private static void d(int i3, int i4, String str) throws GlUtil.GlException {
        int iGlCreateShader = GLES20.glCreateShader(i4);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = {0};
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        GlUtil.f(iArr[0] == 1, GLES20.glGetShaderInfoLog(iGlCreateShader) + ", source: \n" + str);
        GLES20.glAttachShader(i3, iGlCreateShader);
        GLES20.glDeleteShader(iGlCreateShader);
        GlUtil.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int h(int i3, String str) {
        return GLES20.glGetAttribLocation(i3, str);
    }

    private int i(String str) {
        return h(this.f41513a, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int j(byte[] bArr) {
        for (int i3 = 0; i3 < bArr.length; i3++) {
            if (bArr[i3] == 0) {
                return i3;
            }
        }
        return bArr.length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int k(int i3, String str) {
        return GLES20.glGetUniformLocation(i3, str);
    }

    public void e() {
        for (Attribute attribute : this.f41514b) {
            attribute.a();
        }
        for (Uniform uniform : this.f41515c) {
            uniform.a(this.f41518f);
        }
    }

    public void f() {
        GLES20.glDeleteProgram(this.f41513a);
        GlUtil.e();
    }

    public int g(String str) throws GlUtil.GlException {
        int i3 = i(str);
        GLES20.glEnableVertexAttribArray(i3);
        GlUtil.e();
        return i3;
    }

    public int l(String str) {
        return k(this.f41513a, str);
    }

    public void m(String str, float[] fArr, int i3) {
        ((Attribute) Assertions.e((Attribute) this.f41516d.get(str))).c(fArr, i3);
    }

    public void n(boolean z2) {
        this.f41518f = z2;
    }

    public void o(String str, float f3) {
        ((Uniform) Assertions.e((Uniform) this.f41517e.get(str))).c(f3);
    }

    public void p(String str, float[] fArr) {
        ((Uniform) Assertions.e((Uniform) this.f41517e.get(str))).d(fArr);
    }

    public void q(String str, float[] fArr) {
        Uniform uniform = (Uniform) this.f41517e.get(str);
        if (uniform == null) {
            return;
        }
        uniform.d(fArr);
    }

    public void r(String str, int i3) {
        ((Uniform) Assertions.e((Uniform) this.f41517e.get(str))).e(i3);
    }

    public void s(String str, int i3, int i4) {
        ((Uniform) Assertions.e((Uniform) this.f41517e.get(str))).f(i3, i4);
    }

    public void t(String str, int i3, int i4, int i5) {
        Uniform uniform = (Uniform) Assertions.e((Uniform) this.f41517e.get(str));
        uniform.f(i3, i4);
        uniform.g(i5);
    }

    public void u() {
        GLES20.glUseProgram(this.f41513a);
        GlUtil.e();
    }

    public GlProgram(String str, String str2) throws GlUtil.GlException {
        int iGlCreateProgram = GLES20.glCreateProgram();
        this.f41513a = iGlCreateProgram;
        GlUtil.e();
        d(iGlCreateProgram, 35633, str);
        d(iGlCreateProgram, 35632, str2);
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = {0};
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        GlUtil.f(iArr[0] == 1, "Unable to link shader program: \n" + GLES20.glGetProgramInfoLog(iGlCreateProgram));
        GLES20.glUseProgram(iGlCreateProgram);
        this.f41516d = new HashMap();
        int[] iArr2 = new int[1];
        GLES20.glGetProgramiv(iGlCreateProgram, 35721, iArr2, 0);
        this.f41514b = new Attribute[iArr2[0]];
        for (int i3 = 0; i3 < iArr2[0]; i3++) {
            Attribute attributeB = Attribute.b(this.f41513a, i3);
            this.f41514b[i3] = attributeB;
            this.f41516d.put(attributeB.f41519a, attributeB);
        }
        this.f41517e = new HashMap();
        int[] iArr3 = new int[1];
        GLES20.glGetProgramiv(this.f41513a, 35718, iArr3, 0);
        this.f41515c = new Uniform[iArr3[0]];
        for (int i4 = 0; i4 < iArr3[0]; i4++) {
            Uniform uniformB = Uniform.b(this.f41513a, i4);
            this.f41515c[i4] = uniformB;
            this.f41517e.put(uniformB.f41523a, uniformB);
        }
        GlUtil.e();
    }
}
