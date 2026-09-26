package com.distributed_synth.common_library.dto;

public record FileNode(
        String path
) {

    @Override
    public String toString() {
        return path;
    }
}
