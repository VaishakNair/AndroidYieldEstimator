# AndroidYieldEstimator
Android app that detects crops from video stream using either a trained ML model deployed with the app or by contacting a backend server.


22-05-13 15:32:40.818 14465-14526/org.tensorflow.lite.examples.detection E/AndroidRuntime: FATAL EXCEPTION: inference
    Process: org.tensorflow.lite.examples.detection, PID: 14465
    java.lang.IllegalArgumentException: Internal error: Failed to run on the given Interpreter: Next operations are not supported by GPU delegate:
    EXP: Operation is not supported.
    SPLIT_V: Operation is not supported.
    SUB: Expected 2 input tensor(s), but node has 1 runtime input(s).
    First 1 operations will run on the GPU, and the remaining 692 on the CPU.
    OpenCL library not loaded - dlopen failed: library "libOpenCL-pixel.so" not found
    Falling back to OpenGL
    TfLiteGpuDelegate Invoke: Write to buffer failed. Source data is larger than buffer.
    Node
        at org.tensorflow.lite.NativeInterpreterWrapper.run(Native Method)
        at org.tensorflow.lite.NativeInterpreterWrapper.run(NativeInterpreterWrapper.java:154)
        at org.tensorflow.lite.Interpreter.runForMultipleInputsOutputs(Interpreter.java:314)
        at org.tensorflow.lite.examples.detection.tflite.YoloV4Classifier.getDetectionsForFull(YoloV4Classifier.java:390)
        at org.tensorflow.lite.examples.detection.tflite.YoloV4Classifier.recognizeImage(YoloV4Classifier.java:542)
        at org.tensorflow.lite.examples.detection.tflite.YoloV4Classifier.recognizeImage(YoloV4Classifier.java:61)
        at org.tensorflow.lite.examples.detection.DetectorActivity$2.run(DetectorActivity.java:189)
        at android.os.Handler.handleCallback(Handler.java:938)
        at android.os.Handler.dispatchMessage(Handler.java:99)
        at android.os.Looper.loopOnce(Looper.java:233)
        at android.os.Looper.loop(Looper.java:334)
        at android.os.HandlerThread.run(HandlerThread.java:67)
