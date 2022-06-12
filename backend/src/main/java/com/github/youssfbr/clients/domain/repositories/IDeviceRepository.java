package com.github.youssfbr.clients.domain.repositories;

import com.github.youssfbr.clients.domain.entities.Device;
import com.github.youssfbr.clients.domain.services.exceptions.DeviceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDeviceRepository extends JpaRepository<Device, Long> {

    default Device findByIdOrElseThrow(Long deviceId) {
        return findById(deviceId)
                .orElseThrow(DeviceNotFoundException::new);
    }

}
