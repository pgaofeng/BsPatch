#include <jni.h>
#include <string>


extern "C" {
extern int patch_main(int argc, char *argv[]);
}

extern "C"
JNIEXPORT jboolean JNICALL
Java_com_study_bspatch_PatchUtils_bsPatch(JNIEnv *env, jobject thiz, jstring new_file,
                                          jstring old_file, jstring patch_file) {
    const char *newFile = env->GetStringUTFChars(new_file, nullptr);
    const char *oldFile = env->GetStringUTFChars(old_file, nullptr);
    const char *patchFile = env->GetStringUTFChars(patch_file, nullptr);

    char *argv[] = {"", const_cast<char *>(oldFile), const_cast<char *>(newFile),
                    const_cast<char *>(patchFile)};
    int res = patch_main(4, argv);

    env->ReleaseStringUTFChars(old_file, oldFile);
    env->ReleaseStringUTFChars(new_file, newFile);
    env->ReleaseStringUTFChars(patch_file, patchFile);

    return res == 0;
}