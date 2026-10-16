package androidx.media3.exoplayer.video.spherical;

import android.opengl.GLES20;
import android.util.Log;
import androidx.media3.common.util.GlProgram;
import androidx.media3.common.util.GlUtil;
import androidx.media3.exoplayer.video.spherical.Projection;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class ProjectionRenderer {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final float[] f45936j = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final float[] f45937k = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final float[] f45938l = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final float[] f45939m = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final float[] f45940n = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.5f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f45941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MeshData f45942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MeshData f45943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private GlProgram f45944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f45945e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f45946f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f45947g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f45948h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f45949i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class MeshData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f45950a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final FloatBuffer f45951b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final FloatBuffer f45952c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f45953d;

        public MeshData(Projection.SubMesh subMesh) {
            this.f45950a = subMesh.a();
            this.f45951b = GlUtil.j(subMesh.f45934c);
            this.f45952c = GlUtil.j(subMesh.f45935d);
            int i3 = subMesh.f45933b;
            if (i3 == 1) {
                this.f45953d = 5;
            } else if (i3 != 2) {
                this.f45953d = 4;
            } else {
                this.f45953d = 6;
            }
        }
    }

    public static boolean c(Projection projection) {
        Projection.Mesh mesh = projection.f45927a;
        Projection.Mesh mesh2 = projection.f45928b;
        return mesh.b() == 1 && mesh.a(0).f45932a == 0 && mesh2.b() == 1 && mesh2.a(0).f45932a == 0;
    }

    public void a(int i3, float[] fArr, boolean z2) {
        MeshData meshData = z2 ? this.f45943c : this.f45942b;
        if (meshData == null) {
            return;
        }
        int i4 = this.f45941a;
        GLES20.glUniformMatrix3fv(this.f45946f, 1, false, i4 == 1 ? z2 ? f45938l : f45937k : i4 == 2 ? z2 ? f45940n : f45939m : f45936j, 0);
        GLES20.glUniformMatrix4fv(this.f45945e, 1, false, fArr, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i3);
        GLES20.glUniform1i(this.f45949i, 0);
        try {
            GlUtil.e();
        } catch (GlUtil.GlException e3) {
            Log.e("ProjectionRenderer", "Failed to bind uniforms", e3);
        }
        GLES20.glVertexAttribPointer(this.f45947g, 3, 5126, false, 12, (Buffer) meshData.f45951b);
        try {
            GlUtil.e();
        } catch (GlUtil.GlException e4) {
            Log.e("ProjectionRenderer", "Failed to load position data", e4);
        }
        GLES20.glVertexAttribPointer(this.f45948h, 2, 5126, false, 8, (Buffer) meshData.f45952c);
        try {
            GlUtil.e();
        } catch (GlUtil.GlException e5) {
            Log.e("ProjectionRenderer", "Failed to load texture data", e5);
        }
        GLES20.glDrawArrays(meshData.f45953d, 0, meshData.f45950a);
        try {
            GlUtil.e();
        } catch (GlUtil.GlException e6) {
            Log.e("ProjectionRenderer", "Failed to render", e6);
        }
    }

    public void b() {
        try {
            GlProgram glProgram = new GlProgram("uniform mat4 uMvpMatrix;\nuniform mat3 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec2 aTexCoords;\nvarying vec2 vTexCoords;\n// Standard transformation.\nvoid main() {\n  gl_Position = uMvpMatrix * aPosition;\n  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;\n}\n", "// This is required since the texture data is GL_TEXTURE_EXTERNAL_OES.\n#extension GL_OES_EGL_image_external : require\nprecision mediump float;\n// Standard texture rendering shader.\nuniform samplerExternalOES uTexture;\nvarying vec2 vTexCoords;\nvoid main() {\n  gl_FragColor = texture2D(uTexture, vTexCoords);\n}\n");
            this.f45944d = glProgram;
            this.f45945e = glProgram.l("uMvpMatrix");
            this.f45946f = this.f45944d.l("uTexMatrix");
            this.f45947g = this.f45944d.g("aPosition");
            this.f45948h = this.f45944d.g("aTexCoords");
            this.f45949i = this.f45944d.l("uTexture");
        } catch (GlUtil.GlException e3) {
            Log.e("ProjectionRenderer", "Failed to initialize the program", e3);
        }
    }

    public void d(Projection projection) {
        if (c(projection)) {
            this.f45941a = projection.f45929c;
            MeshData meshData = new MeshData(projection.f45927a.a(0));
            this.f45942b = meshData;
            if (!projection.f45930d) {
                meshData = new MeshData(projection.f45928b.a(0));
            }
            this.f45943c = meshData;
        }
    }
}
