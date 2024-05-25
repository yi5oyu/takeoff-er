#!/bin/bash

echo "test success"
# Option 1: 기본 해독 시도 (AES-256-CBC)

  # Option 5: 다른 암호화 방식 시도 (AES-256-CFB)
openssl aes-256-cfb -d -kfile password.txt -in pricetaglist.pem.enc -out scripts/deploy_key.pem
  if [ $? -eq 0 ] && [ -f scripts/deploy_key.pem ]; then
    chmod 400 scripts/deploy_key.pem
    echo "Option 5: Decrypt success"
    ssh -i scripts/deploy_key.pem -o StrictHostKeyChecking=no ec2-user@$EC2_INSTANCE_IP
  else
    echo "Option 5: Failed to decrypt the file."
    rm -f scripts/deploy_key.pem
fi


#  ssh -i pricetaglist.pem -o StrictHostKeyChecking=no ec2-user@$EC2_INSTANCE_IP
echo "fin"