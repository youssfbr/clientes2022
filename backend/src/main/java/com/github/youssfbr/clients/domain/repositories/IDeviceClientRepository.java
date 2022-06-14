package com.github.youssfbr.clients.domain.repositories;

import com.github.youssfbr.clients.domain.entities.DeviceClient;
import com.github.youssfbr.clients.domain.services.exceptions.ClientNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDeviceClientRepository extends JpaRepository<DeviceClient, Long> {

    default DeviceClient findByIdOrElseThrow(Long deviceClientId) {
        return findById(deviceClientId)
                .orElseThrow(ClientNotFoundException::new);
    }

}
