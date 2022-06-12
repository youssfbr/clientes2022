package com.github.youssfbr.clients.domain.repositories;

import com.github.youssfbr.clients.domain.entities.DeviceBrand;
import com.github.youssfbr.clients.domain.services.exceptions.DeviceBrandNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDeviceBrandRepository extends JpaRepository<DeviceBrand, Long> {

    default DeviceBrand findByIdOrElseThrow(Long deviceBrandId) {
        return findById(deviceBrandId)
                .orElseThrow(DeviceBrandNotFoundException::new);
    }

}
