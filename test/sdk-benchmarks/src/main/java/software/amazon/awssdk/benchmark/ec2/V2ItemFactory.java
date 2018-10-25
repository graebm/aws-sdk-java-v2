package software.amazon.awssdk.benchmark.ec2;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import software.amazon.awssdk.services.ec2.model.BlockDeviceMapping;
import software.amazon.awssdk.services.ec2.model.ElasticGpuSpecification;
import software.amazon.awssdk.services.ec2.model.InstanceNetworkInterfaceSpecification;
import software.amazon.awssdk.services.ec2.model.RunInstancesRequest;
import software.amazon.awssdk.services.ec2.model.VolumeType;

final class V2ItemFactory {
    private static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";

    private static final Random RNG = new Random();

    public final RunInstancesRequest tiny() {
        return RunInstancesRequest.builder()
                                  .additionalInfo(randomS(50))
                                  .disableApiTermination(true)
                                  .maxCount(5)
                                  .build();
    }

    public final RunInstancesRequest small() {
        return RunInstancesRequest.builder()
                                  .additionalInfo(randomS(50))
                                  .disableApiTermination(true)
                                  .maxCount(5)
                                  .blockDeviceMappings(blockDeviceMappings(3))
                                  .cpuOptions(c -> c.coreCount(5).threadsPerCore(5))
                                  .elasticGpuSpecification(elasticGpuSpecification())
                                  .networkInterfaces(networkInterfaces(3))
                                  .build();
    }

    public final RunInstancesRequest huge() {
        return RunInstancesRequest.builder()
                                  .additionalInfo(randomS(50))
                                  .disableApiTermination(true)
                                  .maxCount(5)
                                  .blockDeviceMappings(blockDeviceMappings(100))
                                  .cpuOptions(c -> c.coreCount(5).threadsPerCore(5))
                                  .elasticGpuSpecification(elasticGpuSpecification())
                                  .networkInterfaces(networkInterfaces(100))
                                  .build();
    }

    private static ElasticGpuSpecification elasticGpuSpecification() {
        return ElasticGpuSpecification.builder()
                                      .type(randomS(50))
                                      .build();
    }

    private static InstanceNetworkInterfaceSpecification networkInterface() {
        return InstanceNetworkInterfaceSpecification.builder()
                                                    .associatePublicIpAddress(true)
                                                    .deleteOnTermination(true)
                                                    .deviceIndex(50)
                                                    .groups(randomS(50), randomS(50), randomS(50))
                                                    .description(randomS(50))
                                                    .build();
    }

    private static List<InstanceNetworkInterfaceSpecification> networkInterfaces(int num) {
        return IntStream.of(num)
                        .mapToObj(i -> networkInterface())
                        .collect(Collectors.toList());
    }

    private static BlockDeviceMapping blockDeviceMapping() {
        return BlockDeviceMapping.builder()
                                 .deviceName(randomS(100))
                                 .virtualName(randomS(50))
                                 .noDevice(randomS(50))
                                 .ebs(e -> e.deleteOnTermination(true)
                                            .encrypted(false)
                                            .iops(50)
                                            .kmsKeyId(randomS(50))
                                            .snapshotId(randomS(50))
                                            .volumeSize(50)
                                            .volumeType(VolumeType.GP2))
                                 .build();
    }

    private static List<BlockDeviceMapping> blockDeviceMappings(int num) {
        return IntStream.of(num)
                        .mapToObj(i -> blockDeviceMapping())
                        .collect(Collectors.toList());
    }

    private static String randomS(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; ++i) {
            sb.append(ALPHA.charAt(RNG.nextInt(ALPHA.length())));
        }
        return sb.toString();
    }

    private static ByteBuffer randomB(int len) {
        byte[] b = new byte[len];
        RNG.nextBytes(b);
        return ByteBuffer.wrap(b);
    }
}
